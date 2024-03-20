package com.github.thinkami.hellojetbrainsplugin.actions

import com.github.thinkami.hellojetbrainsplugin.backgrounds.UpdateTask
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class HeavyActionWithBackground : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        UpdateTask(project).queue()
    }
}