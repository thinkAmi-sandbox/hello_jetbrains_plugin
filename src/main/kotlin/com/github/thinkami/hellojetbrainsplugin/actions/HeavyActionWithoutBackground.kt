package com.github.thinkami.hellojetbrainsplugin.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.ui.DialogPanel
import com.intellij.openapi.wm.ToolWindowManager
import javax.swing.JLabel

class HeavyActionWithoutBackground : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.getRequiredData(CommonDataKeys.PROJECT)

        // 5秒待つ
        Thread.sleep(5000)

        // ラベルを更新する
        ApplicationManager.getApplication().invokeLater {
            val toolWindow = ToolWindowManager.getInstance(project).getToolWindow("UpdateInActionToolWindow")
                ?: return@invokeLater

            val panelComponent = toolWindow.component.components.filterIsInstance<DialogPanel>().first()
            val labelComponent = panelComponent.components.filterIsInstance<JLabel>().find {
                it.name == "myLabel"
            }

            if (labelComponent != null) {
                labelComponent.text = "Update By Heavy Action"
            }
        }
    }
}