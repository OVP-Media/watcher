rootProject.name = "watcher"

plugins {
    // See https://splitties.github.io/refreshVersions/
    id("de.fayard.refreshVersions") version "0.60.3"
}

refreshVersions {
    // See https://splitties.github.io/refreshVersions/update-dependencies/#filter-which-versions-are-added-to-versionsproperties
    rejectVersionIf {
        candidate.stabilityLevel.isLessStableThan(current.stabilityLevel)
    }
}
