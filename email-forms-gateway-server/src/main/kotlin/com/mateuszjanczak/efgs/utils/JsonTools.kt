package com.mateuszjanczak.efgs.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.stream.Collectors
import javax.servlet.http.HttpServletRequest

fun getJsonFromRequest(request: HttpServletRequest): String = request.reader.lines().collect(Collectors.joining())

fun getMapFromJson(json: String): Map<String, Any> =
    Gson().fromJson(json, object : TypeToken<HashMap<String?, Any?>?>() {}.type)