package com.github.thinkami.hellojetbrainsplugin.ui

import javax.swing.table.DefaultTableCellRenderer

class AppleTableCellRenderer: DefaultTableCellRenderer() {
    override fun setValue(value: Any?) {
        if (value == "黄") {
            // 黄色の場合だけ、シナノゴールドのアイコンに差し替える
            icon = AppleTableCellIcon.ShinanoGold
            text = ""
            return
        }

        icon = null
        text = value.toString()
    }
}