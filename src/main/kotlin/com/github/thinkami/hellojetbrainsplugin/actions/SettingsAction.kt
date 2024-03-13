package com.github.thinkami.hellojetbrainsplugin.actions

import com.github.thinkami.hellojetbrainsplugin.ui.SettingsDialog
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class SettingsAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val dialog = SettingsDialog()
        if (dialog.showAndGet()) {
            // OKボタンをクリックした場合に、コンソールへHelloを出力する
            println("Hello")
        }
    }
}