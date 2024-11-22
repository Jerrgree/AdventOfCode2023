fun main() {
    val input = readInput("Day01")
    var sum = 0

    for (row in input) {
        //sum += StringUtilities.processCalibrationRow(row)
        sum += StringUtilities.processCalibrationRowEnhanced(row)
    }

    sum.println()
}