package fr.rtransat.ovp.watcher

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test", "test-local")
class WatcherApplicationTests {

    @Test
    fun `simple test`() {
        val appName = "watcher"
        appName shouldBe "watcher"
    }

}
