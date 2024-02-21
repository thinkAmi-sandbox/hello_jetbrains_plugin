package com.github.thinkami.hellojetbrainsplugin.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class HelloAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(buildString {
            append("ハロー")
        }, "ワールド", null)
    }
}