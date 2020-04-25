package com.jskierbi.logplayground

import org.apache.logging.log4j.LogManager


val logger = LogManager.getLogger()

fun main(args: Array<String>) {
    logger.debug(">>> Hello, world!")
}
