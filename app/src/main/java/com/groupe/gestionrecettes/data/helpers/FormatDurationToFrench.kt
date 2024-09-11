package com.groupe.gestionrecettes.data.helpers

fun formatDurationToFrench(duration: String): String {
    // Regular expression to match hours and minutes in the ISO 8601 format
    val regex = """PT(?:(\d+)H)?(?:(\d+)M)?""".toRegex()
    val matchResult = regex.matchEntire(duration)

    return if (matchResult != null) {
        val (hours, minutes) = matchResult.destructured

        // Build the formatted string
        buildString {
            if (hours.isNotEmpty()) {
                append("${hours.toInt()} h")
                if (minutes.isNotEmpty()) {
                    append(" ${minutes.toInt()}") // Add space between hours and minutes
                }
            } else if (minutes.isNotEmpty()) {
                append("${minutes.toInt()} m")
            }
        }
    } else {
        // Return empty if the input format is not recognized
        ""
    }
}
