# Custom loader for Glide 4
_(Note that this does not work for Glide 3.x)_

Example project of how to implement a custom loader for Glide 4. This can be used to load any class with glide.
This example enables Glide to load an instance of `Palette` and produce a bitmap resource based on that instance.

```
data class Palette(val topLeft: Int,
                   val topRight: Int,
                   val bottomRight: Int,
                   val bottomLeft: Int)
```
The same concept can be applied for other classes to fit your need.


## Dependencies 
**Glide 4.3.1 or newer.** 
4.3.0 and older versions will result in the crash below.

## Running the sample app
The sample app will load a <span style="color:green">green</span> image.
 
 There is a <span style="color:yellow">TODO</span> added to indicate where any bitmap can be used.
## Issue using Glide versions prior to 4.3.1

The app crashes with `java.lang.IllegalStateException: Can't compress a recycled bitmap`

Full stacktrace:

```GlideExecutor: Request threw uncaught throwable
java.lang.IllegalStateException: Can't compress a recycled bitmap
at android.graphics.Bitmap.checkRecycled(Bitmap.java:374)
at android.graphics.Bitmap.compress(Bitmap.java:1225)
at com.bumptech.glide.load.resource.bitmap.BitmapEncoder.encode(BitmapEncoder.java:66)
at com.bumptech.glide.load.resource.bitmap.BitmapEncoder.encode(BitmapEncoder.java:31)
at com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder.encode(BitmapDrawableEncoder.java:27)
at com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder.encode(BitmapDrawableEncoder.java:15)
at com.bumptech.glide.load.engine.DataCacheWriter.write(DataCacheWriter.java:30)
at com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper.put(DiskLruCacheWrapper.java:112)
at com.bumptech.glide.load.engine.DecodeJob$DeferredEncodeManager.encode(DecodeJob.java:639)
at com.bumptech.glide.load.engine.DecodeJob.notifyEncodeAndRelease(DecodeJob.java:435)
at com.bumptech.glide.load.engine.DecodeJob.decodeFromRetrievedData(DecodeJob.java:412)
at com.bumptech.glide.load.engine.DecodeJob.onDataFetcherReady(DecodeJob.java:375)
at com.bumptech.glide.load.engine.SourceGenerator.onDataReady(SourceGenerator.java:111)
at com.subgarden.glidecustomloader.PaletteDataFetcher.loadData(PaletteDataFetcher.kt:13)
at com.bumptech.glide.load.engine.SourceGenerator.startNext(SourceGenerator.java:61)
at com.bumptech.glide.load.engine.DecodeJob.runGenerators(DecodeJob.java:298)
at com.bumptech.glide.load.engine.DecodeJob.runWrapped(DecodeJob.java:268)
at com.bumptech.glide.load.engine.DecodeJob.run(DecodeJob.java:229)
at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
at java.lang.Thread.run(Thread.java:764)
at com.bumptech.glide.load.engine.executor.GlideExecutor$DefaultThreadFactory$1.run(GlideExecutor.java:413)```
