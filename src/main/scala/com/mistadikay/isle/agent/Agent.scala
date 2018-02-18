package com.mistadikay.isle.agent

object Agent extends App {
  type OptionMap = Map[Symbol, Any]

  // basic health reporter
  def reportHealthy(): Unit = println("healthy")

  // parses options recursively
  def parseOptions(map: OptionMap, list: List[String]): OptionMap = {
    list match {
      case "--frequency" :: value :: tail =>
        parseOptions(map ++ Map('frequency -> value.toInt), tail)
      case "--type" :: value :: tail =>
        value match {
          case "heartbeat" | "filecheck" =>
            parseOptions(map ++ Map('type -> value.toString), tail)
          case unknownType =>
            throw new Error("Unknown option --type: " + unknownType)
        }
      case "--location" :: value :: tail =>
        parseOptions(map ++ Map('location -> value.toString), tail)
      case _ :: _ => map
      case Nil    => map
    }
  }

  // Read provided options or initiate with default values
  val options = parseOptions(Map(), args.toList)
  val frequency = options.getOrElse('frequency, 1000).toString.toInt
  val checkType = options.getOrElse('type, "heartbeat").toString
  val location = options.getOrElse('location, "").toString

  // --location is required for filecheck
  if (checkType == "filecheck" && location == "")
    throw new Error("Missing --location param")

  val checker = checkType match {
    case "heartbeat" =>
      () =>
        reportHealthy()
    case "filecheck" =>
      () =>
        if (new java.io.File(location).exists()) reportHealthy()
  }

  while (true) {
    checker()
    Thread sleep frequency
  }
}
