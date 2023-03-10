package com.tadvlasov.tooltests.features.rest.responseModels

data class UserRS(
    var id: String,
    var groups: List<String>,
    var ns: Boolean,
    var fio: String,
) : ErrorRS()
