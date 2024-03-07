package com.github.thinkami.hellojetbrainsplugin.toolWindow

import com.github.thinkami.hellojetbrainsplugin.ui.UpdateInActionContent
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory

class UpdateInActionToolWindowFactory : ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val content = ContentFactory.getInstance().createContent(UpdateInActionContent().contentPanel, null, false)
        toolWindow.contentManager.addContent(content)
    }
}