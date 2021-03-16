package io.kraftsman.linebotsample.controllers

import com.linecorp.bot.model.event.MessageEvent
import com.linecorp.bot.model.event.message.TextMessageContent
import com.linecorp.bot.model.message.Message
import com.linecorp.bot.model.message.TextMessage
import com.linecorp.bot.spring.boot.annotation.EventMapping
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler
import io.kraftsman.linebotsample.DemoApplication
import org.slf4j.LoggerFactory

@LineMessageHandler
class LineBotController {
    private val log = LoggerFactory.getLogger(DemoApplication::class.java)

    @EventMapping
    fun handleTextMessageEvent(event: MessageEvent<TextMessageContent>): Message {
        log.info("event: $event")
        val originalMessageText = event.message.text
        return TextMessage(originalMessageText)
    }
}
