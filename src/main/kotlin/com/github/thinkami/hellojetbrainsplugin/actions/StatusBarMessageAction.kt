package com.github.thinkami.hellojetbrainsplugin.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.wm.WindowManager

class StatusBarMessageAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return

        val statusBar = WindowManager.getInstance().getStatusBar(project)
        statusBar.let {
            it.info = "Message with Status Bar. \n Hello world" // 改行は効かない
        }
    }
}