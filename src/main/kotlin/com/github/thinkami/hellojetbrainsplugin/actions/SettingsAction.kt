package com.github.thinkami.hellojetbrainsplugin.actions

import com.github.thinkami.hellojetbrainsplugin.ui.SettingsDialog
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class SettingsAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val dialog = SettingsDialog()
        if (dialog.showAndGet()) {
            // OKボタンをクリックしたときに、コンソールへコンボボックスの選択値を出力する
            val combo = dialog.comboBox
            val selectedType = combo.getItemAt(combo.selectedIndex)
            println(selectedType)
        }
    }
}