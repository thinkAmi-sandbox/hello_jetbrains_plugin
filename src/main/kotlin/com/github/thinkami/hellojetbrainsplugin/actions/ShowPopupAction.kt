package com.github.thinkami.hellojetbrainsplugin.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.openapi.wm.ToolWindowManager

class ShowPopupAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val manager = ToolWindowManager.getInstance(project)
        val toolWindow = manager.getToolWindow("NotificationToolWindow")
        val factory = JBPopupFactory.getInstance()

        // createConfirmation() では、改行を設定できないっぽい
        factory.createConfirmation(
            "Message with popup <br> Hello world",
            "Yes\nclick",
            "No <br> click",
            MyRun(), 0)
            .showInCenterOf(toolWindow!!.component)
    }
}

class MyRun: Runnable {
    override fun run() {
        println("hello")
    }
}