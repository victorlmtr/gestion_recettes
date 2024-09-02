package com.groupe.gestionrecettes.data

import com.groupe.gestionrecettes.R
import java.time.Duration

data class Step(
    val id: Int,
    val length: String,
    val instructions: String,
    val imageRes: ByteArray?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Step

        if (imageRes != null) {
            if (other.imageRes == null) return false
            if (!imageRes.contentEquals(other.imageRes)) return false
        } else if (other.imageRes != null) return false

        return true
    }

    override fun hashCode(): Int {
        return imageRes?.contentHashCode() ?: 0
    }
}