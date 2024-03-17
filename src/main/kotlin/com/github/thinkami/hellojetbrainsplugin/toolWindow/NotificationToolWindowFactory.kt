package com.github.thinkami.hellojetbrainsplugin.toolWindow

import com.github.thinkami.hellojetbrainsplugin.ui.NotificationContent
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory

class NotificationToolWindowFactory: ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val content = ContentFactory.getInstance().createContent(NotificationContent().contentPanel, "", false)
        toolWindow.contentManager.addContent(content)
    }
}