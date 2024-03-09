package com.github.thinkami.hellojetbrainsplugin.ui

import javax.swing.table.AbstractTableModel

class AppleTableModel: AbstractTableModel() {
    val allData: List<List<String>> = listOf(
        listOf("1", "シナノゴールド", "黄"),
        listOf("2", "シナノホッペ", "赤"),
        listOf("3", "ジョナゴールド", "赤"),
    )

    val columns: List<String> = listOf("No", "Name", "Color")

    override fun getRowCount(): Int {
        return allData.size
    }

    override fun getColumnCount(): Int {
        return columns.size
    }

    override fun getValueAt(rowIndex: Int, columnIndex: Int): Any {
        return allData[rowIndex][columnIndex]
    }
}