package com.jorgila.dragonballapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform