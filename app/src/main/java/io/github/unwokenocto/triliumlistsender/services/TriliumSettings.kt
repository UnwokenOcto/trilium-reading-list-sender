package io.github.unwokenocto.triliumlistsender.services

import android.app.Activity
import android.content.Context

class TriliumSettings constructor(ctx: Activity) {
    companion object {
        const val PREF_NAME = "io.github.unwokenocto.triliumlistsender.setup"
        const val PREF_TRILIUM_ADDRESS = "trilium_address"
        const val PREF_API_TOKEN = "api_token"
        const val PREF_NOTE_LABEL = "trilium_note_label"
        const val PREF_LIST_PRESETS = "trilium_list_presets"
        const val PREF_SUBLIST_PRESETS = "trilium_sublist_presets"
    }

    fun save(triliumAddress: String, apiToken: String, noteLabel: String, listPresets: String, sublistPresets: String) {
        val editor = prefs.edit()
        editor.putString(PREF_TRILIUM_ADDRESS, triliumAddress)
        editor.putString(PREF_API_TOKEN, apiToken)
        editor.putString(PREF_NOTE_LABEL, noteLabel)
        editor.putString(PREF_LIST_PRESETS, listPresets)
        editor.putString(PREF_SUBLIST_PRESETS, sublistPresets)
        editor.apply()
    }

    private val prefs = ctx.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    val triliumAddress
        get() = prefs.getString(PREF_TRILIUM_ADDRESS, "")!!

    val apiToken
        get() = prefs.getString(PREF_API_TOKEN, "")!!

    val noteLabel
        get() = prefs.getString(PREF_NOTE_LABEL, "")!!

    val listPresets
        get() = prefs.getString(PREF_LIST_PRESETS, "")!!

    val sublistPresets
        get() = prefs.getString(PREF_SUBLIST_PRESETS, "")!!

    fun isConfigured() = !triliumAddress.isBlank() && !apiToken.isBlank()
}
