package com.github.thinkami.hellojetbrainsplugin.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.ui.DialogPanel
import com.intellij.openapi.wm.ToolWindowManager
import com.intellij.testFramework.requireIs
import javax.swing.JLabel

class UpdateLabelAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        // AnActionEventに含まれる project の値を取得する
        val project = e.getRequiredData(CommonDataKeys.PROJECT)

        // UIスレッドで非同期に処理を実行する
        ApplicationManager.getApplication().invokeLater {
            // project を元に ToolWindowを取得する
            val toolWindow = ToolWindowManager.getInstance(project).getToolWindow("UpdateInActionToolWindow")
                // ToolWindowが存在しない場合は何も処理しない
                ?: return@invokeLater

            // DialogPanelは1つしかないはず
            val panelComponent = toolWindow.component.components.filterIsInstance<DialogPanel>().first()

            // myLabelというnameを持ったlabelは1つしかないはず
            val labelComponent = panelComponent.components.filterIsInstance<JLabel>().find {
                it.name == "myLabel"
            }

            if (labelComponent != null) {
                labelComponent.text = "updated"
            }
        }
    }
}