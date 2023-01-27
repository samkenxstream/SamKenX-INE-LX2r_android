/*
 * Copyright (c) 2023 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.app.features.roomprofile.polls.list.ui

import im.vector.app.features.home.room.detail.timeline.item.PollOptionViewState

sealed interface PollSummary {
    val id: String
    val creationTimestamp: Long
    val title: String
    val optionViewStates: List<PollOptionViewState>

    data class ActivePoll(
            override val id: String,
            override val creationTimestamp: Long,
            override val title: String,
            override val optionViewStates: List<PollOptionViewState>,
    ) : PollSummary

    data class EndedPoll(
            override val id: String,
            override val creationTimestamp: Long,
            override val title: String,
            val totalVotes: Int,
            val winnerOptions: List<PollOptionViewState.PollEnded>,
            override val optionViewStates: List<PollOptionViewState>,
    ) : PollSummary
}
