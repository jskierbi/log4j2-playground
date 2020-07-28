package com.jskierbi.logplayground

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger


val logger1 = LogManager.getLogger("something.else")
val logger2 = LogManager.getLogger("com.jskierbi")
val logger3 = LogManager.getLogger("com.jskierbi.test")
class Something(
        val logger: Logger = LogManager.getLogger(Something::class.java)
) 

fun main(args: Array<String>) {
    logger1.debug("[1] DEBUG")
    logger1.info("[1] INFO")
    logger1.warn("[1] WARN")
    logger1.error("[1] ERROR")

    logger2.debug("[2] DEBUG")
    logger2.info("[2] INFO")
    logger2.warn("[2] WARN")
    logger2.error("[2] ERROR")
    
    logger3.debug("[3] DEBUG")
    logger3.info("[3] INFO")
    logger3.warn("[3] WARN")
    logger3.error("[3] ERROR")
    
    val something = Something()
    something.logger.debug("[S] DEBUG")
    something.logger.info("[S] INFO")
    something.logger.warn("[S] WARN")
    something.logger.error("[S] ERROR")
}
