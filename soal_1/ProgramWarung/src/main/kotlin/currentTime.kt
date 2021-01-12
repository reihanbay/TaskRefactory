import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateNow(pattern : String) {
    val current = LocalDateTime.now()

    val formatter = DateTimeFormatter.ofPattern(pattern)
    val now = current.format(formatter)

}