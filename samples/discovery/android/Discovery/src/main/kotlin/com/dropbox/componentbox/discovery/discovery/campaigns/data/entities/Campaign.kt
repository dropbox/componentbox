package com.dropbox.componentbox.discovery.discovery.campaigns.data.entities

sealed class Campaign {
    interface PromptCampaign {
        val id: String
    }

    interface ComponentBoxCampaign<P : PromptCampaign> {
        val promptCampaign: P
        val componentBoxId: String
    }

    sealed class Banner : Campaign() {
        data class PromptBanner(
            override val id: String,
            val text: String,
            val subtext: String,
            val style: BannerStyle,
            val action: CampaignAction,
            val iconStart: String,
            val iconEnd: String,
        ) : Banner(), PromptCampaign

        data class PromptBigBanner(
            override val id: String,
            val imageUrl: String,
            val text: String,
            val subtext: String,
            val style: BannerStyle,
            val action: CampaignAction,
            val confirmText: String
        ) : Banner(), PromptCampaign

        data class ComponentBoxBanner(
            override val promptCampaign: PromptBanner,
            override val componentBoxId: String
        ) : Banner(), ComponentBoxCampaign<PromptBanner>

        data class ComponentBoxBigBanner(
            override val promptCampaign: PromptBigBanner,
            override val componentBoxId: String
        ) : Banner(), ComponentBoxCampaign<PromptBigBanner>
    }

    sealed class Modal : Campaign() {
        data class PromptModal(
            override val id: String,
            val imageUrl: String,
            val text: String,
            val subtext: String,
            val action: CampaignAction,
            val confirmText: String,
            val dismissText: String
        ) : Modal(), PromptCampaign

        data class ComponentBoxModal(
            override val promptCampaign: PromptModal,
            override val componentBoxId: String
        ) : Modal(), ComponentBoxCampaign<PromptModal>
    }

    sealed class UpgradeScreen : Campaign() {
        data class PromptUpgradeScreen(
            override val id: String,
            val title: String,
            val imageUrl: String,
            val text: String,
            val subtext: String,
            val benefitList: List<String>,
            val actionText: String,
            val dismissText: String,
        ) : UpgradeScreen(), PromptCampaign

        data class ComponentBoxUpgradeScreen(
            override val promptCampaign: PromptUpgradeScreen,
            override val componentBoxId: String
        ) : UpgradeScreen(), ComponentBoxCampaign<PromptUpgradeScreen>
    }
}