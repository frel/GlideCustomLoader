package com.subgarden.glidecustomloader

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.ResourceDecoder
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapResource
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource

/**
 * @author Fredrik Larsen <f@subgarden.com>
 */
class PaletteDecoder(private var context: Context, private val bitmapPool: BitmapPool) : ResourceDecoder<Palette, BitmapDrawable>{

    override fun handles(source: Palette, options: Options): Boolean {
        return true
    }

    override fun decode(source: Palette?, width: Int, height: Int, options: Options?): Resource<BitmapDrawable>? {
        checkNotNull(source)
        val bitmap = generateBitmap(source, width, height, options)
        val bitmapResource = BitmapResource.obtain(bitmap, bitmapPool)

        return LazyBitmapDrawableResource.obtain(context.resources, bitmapPool, bitmapResource!!.get())
    }

    @Suppress("UNUSED_PARAMETER")
    private fun generateBitmap(source: Palette?, width: Int, height: Int, options: Options?): Bitmap? {
        // TODO Implement actual bitmap generation here
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        bitmap.eraseColor(Color.GREEN)
        return bitmap
    }
}

