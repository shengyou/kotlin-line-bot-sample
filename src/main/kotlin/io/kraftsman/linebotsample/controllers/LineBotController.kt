package io.kraftsman.linebotsample.controllers

import com.linecorp.bot.client.LineMessagingClient
import com.linecorp.bot.model.ReplyMessage
import com.linecorp.bot.model.event.MessageEvent
import com.linecorp.bot.model.event.message.TextMessageContent
import com.linecorp.bot.model.message.TextMessage
import com.linecorp.bot.spring.boot.annotation.EventMapping
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

@LineMessageHandler
class LineBotController(
    @Autowired val lineMessagingClient: LineMessagingClient,
) {
    private val log = LoggerFactory.getLogger(LineBotController::class.java)

    @EventMapping
    fun handleTextMessageEvent(event: MessageEvent<TextMessageContent>) {
        when (event.message.text) {
            "ping" -> {
                val apiResponse = lineMessagingClient.replyMessage(
                    ReplyMessage(
                        event.replyToken,
                        listOf(TextMessage("Pong"))
                    )
                ).get()
                log.info("Sent messages: {}", apiResponse)
            }
        }
    }
}
