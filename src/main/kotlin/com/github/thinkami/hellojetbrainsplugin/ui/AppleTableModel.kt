package com.github.thinkami.hellojetbrainsplugin.ui

import javax.swing.table.AbstractTableModel

class AppleTableModel : AbstractTableModel() {
    val allData: List<List<String>> = listOf(
        listOf("1", "シナノゴールド", "黄"),
        listOf("2", "シナノホッペ", "赤"),
        listOf("3", "ジョナゴールド", "赤"),
    )
    val columns: List<String> = listOf("No", "Name", "Color")

    lateinit var tableData: List<List<String>>

    init {
        // 初期段階で絞り込みを実行する
        filterChanged()
    }

    override fun getRowCount(): Int {
        return tableData.size
    }

    override fun getColumnCount(): Int {
        return columns.size
    }

    override fun getValueAt(rowIndex: Int, columnIndex: Int): Any {
        return tableData[rowIndex][columnIndex]
    }

    override fun getColumnName(column: Int): String {
        return columns[column]
    }

    fun filterChanged() {
        tableData = allData.filter {
            val name = it[1] // Nameで絞り込むため、列番号を指定
            val regex = Regex("シナノ")
            regex.containsMatchIn(name)
        }.toList() // allDataとは別オブジェクトにするため toList する

        // filterが更新されたことを通知する
        this.fireTableDataChanged()
    }
}