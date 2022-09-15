package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Color

interface Icon<Id : Any> : Asset {
    var id: Id
    var color: Color?
}