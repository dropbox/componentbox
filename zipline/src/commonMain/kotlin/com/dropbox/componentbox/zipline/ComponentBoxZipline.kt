package com.dropbox.componentbox.zipline

import app.cash.zipline.ZiplineService
import com.dropbox.componentbox.Forest
import com.dropbox.componentbox.Graph

sealed interface ComponentBoxZipline : ZiplineService
interface ComponentBoxGraph : Graph.Dynamic, ComponentBoxZipline
interface ComponentBoxForest : Forest.Dynamic, ComponentBoxZipline
interface ComponentBoxTrail : ComponentBoxZipline
interface ComponentBoxTree : ComponentBoxZipline
