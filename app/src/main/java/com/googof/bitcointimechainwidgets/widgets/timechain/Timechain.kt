package com.googof.bitcointimechainwidgets.widgets.timechain

import kotlinx.serialization.Serializable

@Serializable
sealed interface TimechainInfo {
    @Serializable
    object Loading : TimechainInfo

    @Serializable

    object Refreshing : TimechainInfo

    @Serializable
    data class Available(
        val fastestFee: String,
        val halfHourFee: String,
        val hourFee: String,
        val economyFee: String,
        val minimumFee: String,
        val currentHashrate: Double,
        val currentDifficulty: Double,
        val count: Int,
        val blockHeight: String,
        val totalNode: Int,
        val ln_channel_count: Long,
        val ln_node_count: Long,
        val ln_total_capacity: Long,
        val blocks: List<Block>,
        val moscowTime: Int,
        val nextHalving: NextHalving

        ) : TimechainInfo

    @Serializable
    data class Unavailable(val message: String) : TimechainInfo
}

//GlanceInfo Data
data class Fees(

    val fastestFee: String,
    val halfHourFee: String,
    val hourFee: String,
    val economyFee: String,
    val minimumFee: String,
)

data class Hashrate(
    val currentHashrate: Double,
    val currentDifficulty: Double,
)

data class UnconfirmedTX(
    val count: Int,
)

@Serializable
data class Block(
    val height: String,
    val size: Int,
    val weight: Int,
    val timestamp: Long,
    val extras: Extras,
)

@Serializable
data class Extras(
    val reward: Int,
)

//Lightning Network
data class LightningNetworkData(
    val channel_count: Long,
    val node_count: Long,
    val total_capacity: Long,
    val tor_nodes: Long,
)

data class LightningNetwork(
    val latest: LightningNetworkData,
)

//Bitnodes.io Data
data class Snapshot(
    val url: String,
    val timestamp: Int,
    val total_nodes: Int,
    val latest_height: Int,
)

data class Nodes(
    val count: Int,
    val next: String,
    val previous: String?,
    val results: List<Snapshot>,
)

//bitcoinexplorer
data class MoscowTime(
    val usd: Int,
    val eur: Int,
    val gbp: Int,
    val xau: Int,
)

@Serializable
data class NextHalving(
    val nextHalvingIndex: Int,
    val nextHalvingBlock: Int,
    val nextHalvingSubsidy: String,
    val blocksUntilNextHalving: Int,
    val timeUntilNextHalving: String,
    val nextHalvingEstimatedDate: String,
)