package com.electromagnetic.sandbox

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("/user")
    fun getUser(): String {
        return "TEST USER"
    }

}