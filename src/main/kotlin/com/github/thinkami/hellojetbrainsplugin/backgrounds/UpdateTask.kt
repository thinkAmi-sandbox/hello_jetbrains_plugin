package com.github.thinkami.hellojetbrainsplugin.backgrounds

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogPanel
import com.intellij.openapi.wm.ToolWindowManager
import javax.swing.JLabel

class UpdateTask(private val project: Project): Task.Backgroundable(project, "task start...") {
    override fun run(indicator: ProgressIndicator) {
        indicator.fraction = 0.1
        indicator.text = "Heavy process start"

        Thread.sleep(5000)

        indicator.fraction = 0.9
        indicator.text = "Heavy process end"

        ApplicationManager.getApplication().invokeLater {
            val toolWindow = ToolWindowManager.getInstance(project).getToolWindow("UpdateInActionToolWindow")
                ?: return@invokeLater

            val panelComponent = toolWindow.component.components.filterIsInstance<DialogPanel>().first()
            val labelComponent = panelComponent.components.filterIsInstance<JLabel>().find {
                it.name == "myLabel"
            }

            if (labelComponent != null) {
                labelComponent.text = "Update By Heavy Action With Background"
            }
        }
    }
}