package com.dongtronic.diabot.commands.misc

import com.dongtronic.diabot.util.ServerRoles
import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandEvent
import org.jsoup.Jsoup

import java.io.IOException

class ExcuseCommand(category: Command.Category) : Command() {

    init {
        this.name = "excuse"
        this.help = "gibs excus"
        this.category = category
        this.requiredRole = ServerRoles.required
        this.guildOnly = true
    }

    override fun execute(event: CommandEvent) {
        try {
            val html = Jsoup.connect("http://programmingexcuses.com/").get()

            val excuse = html.select("a").first().text()

            event.reply(excuse)
        } catch (e: IOException) {
            event.replyError("Oops")
        }

    }
}
