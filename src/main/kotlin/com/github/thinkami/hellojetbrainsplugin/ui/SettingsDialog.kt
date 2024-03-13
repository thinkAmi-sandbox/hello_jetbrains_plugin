package com.github.thinkami.hellojetbrainsplugin.ui

import com.intellij.ide.util.PropertiesComponent
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

        // コンボボックスの初期値として、設定が保存されていればその値を使用する
        val properties = PropertiesComponent.getInstance()
        val matchType = properties.getValue("matchType")
        if (!matchType.isNullOrBlank()) {
            comboBox.selectedItem = matchType
        }

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