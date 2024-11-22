class StringUtilities {
    companion object {
        @Suppress("unused") //base solution
        fun processCalibrationRow(input: String) : Int {
            var firstDigit = '0'
            var lastDigit = '0'
            var firstDigitFound = false

            input.forEach { c ->
                if (c.isDigit()) {
                    lastDigit = c

                    if (firstDigitFound) {
                        return@forEach
                    }

                    firstDigit = lastDigit
                    firstDigitFound = true
                }
            }
            return "$firstDigit$lastDigit".toInt()
        }

        fun processCalibrationRowEnhanced(input: String) : Int {
            var firstDigitLocation = -1
            var lastDigitLocation = -1
            var firstDigit = '0'
            var lastDigit = '0'

            // First find the base digits
            input.forEachIndexed { i, c ->
                if (c.isDigit()) {
                    lastDigitLocation = i
                    lastDigit = c

                    if (firstDigitLocation >= 0) {
                        return@forEachIndexed
                    }

                    firstDigitLocation = i
                    firstDigit = lastDigit
                }
            }
            val wordRegex = "(?=(one|two|three|four|five|six|seven|eight|nine))".toRegex()
            wordRegex.findAll(input)

            val matches = wordRegex.findAll(input)

            for(match in matches) {
                val index = match.range.first

                if (index < firstDigitLocation || firstDigitLocation == -1) {
                    firstDigit = (48 + getDigitFromWord(match.groupValues[1])).toChar()
                    firstDigitLocation = index
                }

                if (index > lastDigitLocation) {
                    lastDigit = (48 + getDigitFromWord(match.groupValues[1])).toChar()
                    lastDigitLocation = index
                }
            }

            return "$firstDigit$lastDigit".toInt()
        }

        fun getDigitFromWord(input: String): Int {
            return when(input.lowercase()) {
                "one" -> 1
                "two" -> 2
                "three" -> 3
                "four" -> 4
                "five" -> 5
                "six" -> 6
                "seven" -> 7
                "eight" -> 8
                "nine" -> 9
                else -> {
                    0
                }
            }
        }
    }
}