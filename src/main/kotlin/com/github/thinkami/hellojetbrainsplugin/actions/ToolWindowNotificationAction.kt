package com.github.thinkami.hellojetbrainsplugin.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.MessageType
import com.intellij.openapi.wm.ToolWindowManager

class ToolWindowNotificationAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        ToolWindowManager.getInstance(project).notifyByBalloon(
            "NotificationToolWindow",
            MessageType.INFO,
            "Tool Window Notify <br> Hello world"
        )
    }
}