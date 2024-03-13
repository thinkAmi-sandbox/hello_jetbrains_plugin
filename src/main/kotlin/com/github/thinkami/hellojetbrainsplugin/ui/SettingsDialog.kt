package com.github.thinkami.hellojetbrainsplugin.ui

import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComboBox
import javax.swing.JComponent

class SettingsDialog: DialogWrapper(true) {
    val comboBox: JComboBox<String>

    init {
        title = "My Settings"

        comboBox = JComboBox<String>()
        comboBox.addItem("Preamble match") // 前方一致
        comboBox.addItem("Partial match")  // 部分一致
        comboBox.name = "matchType"

        init()
    }

    override fun createCenterPanel(): JComponent {
        return panel {
            row {
                label("Hello")
            }
            row {
                cell(comboBox)
            }
        }
    }
}