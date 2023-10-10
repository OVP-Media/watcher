package fr.rtransat.ovp.watcher

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WatcherApplication

fun main(args: Array<String>) {
    runApplication<WatcherApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
