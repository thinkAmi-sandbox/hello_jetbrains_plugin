package com.github.thinkami.hellojetbrainsplugin.actions

import com.github.thinkami.hellojetbrainsplugin.ui.SettingsDialog
import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.ApplicationManager

class SettingsAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        ApplicationManager.getApplication().invokeLater {
            val dialog = SettingsDialog()
            if (dialog.showAndGet()) {
                // OKボタンをクリックしたときに、コンソールへコンボボックスの選択値を出力する
                val combo = dialog.comboBox
                val selectedType = combo.getItemAt(combo.selectedIndex)
                println(selectedType)

                // コンボボックスの選択値を永続化する
                val properties = PropertiesComponent.getInstance()
                properties.setValue("matchType", selectedType)
            }
        }
    }
}