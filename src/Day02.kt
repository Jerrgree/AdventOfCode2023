@file:Suppress("unused")

import kotlin.math.max

fun main() {
    val input = readInput("Day02")
    var sum = 0

    for (row in input) {
        sum += processRow2(row)
    }
    sum.println()
}

fun processRow(row: String): Int {
    val colonIndex = row.indexOf(':')
    val id = row.substring(0, colonIndex).split(' ')[1].toInt();
    val moves = row.substring(colonIndex + 2, row.length).split(';')

    for(move in moves) {
        if (!isValidMove(move))
            return 0
    }

    return id
}

fun isValidMove(move: String): Boolean {
    val maxRed = 12
    val maxGreen = 13
    val maxBlue = 14

    var cubes = move.trim().split(',')

    for (cube in cubes) {
        val details = cube.trim().split(' ')
        val color = details[1]
        val count = details[0].toInt()

        if (color == "green" && count > maxGreen)
            return false
        else if (color == "red" && count > maxRed)
            return false
        else if (color == "blue" && count > maxBlue)
            return false
    }

    return true
}

fun processRow2(row: String): Int {
    var maxRed = 0
    var maxGreen = 0
    var maxBlue = 0
    val colonIndex = row.indexOf(':')
    val moves = row.substring(colonIndex + 2, row.length).split(';')

    for(move in moves) {
        val result = processMove(move)

            maxRed = max(result.first, maxRed)
            maxGreen = max(result.second, maxGreen)
            maxBlue = max(result.third, maxBlue)
    }

    return maxRed * maxGreen * maxBlue
}

fun processMove(move: String): Triple<Int, Int, Int> {
    var maxRed = 0
    var maxGreen = 0
    var maxBlue = 0

    var cubes = move.trim().split(',')

    for (cube in cubes) {
        val details = cube.trim().split(' ')
        val color = details[1]
        val count = details[0].toInt()

        if (color == "green")
            maxGreen = max(maxGreen, count)
        else if (color == "red")
            maxRed = max(maxRed, count)
        else if (color == "blue")
            maxBlue = max(maxBlue, count)
    }

    return Triple(maxRed, maxGreen, maxBlue)
}