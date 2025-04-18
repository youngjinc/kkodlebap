package com.oznnni.kkodlebap.presentation.content

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.oznnni.kkodlebap.R
import com.oznnni.kkodlebap.designsystem.theme.KkodlebapTheme
import com.oznnni.kkodlebap.designsystem.theme.Typography

@Composable
fun TutorialModalContent(
    onClickClose: () -> Unit,
) {
    val scrollState = rememberScrollState()
    val appBarAlpha by animateFloatAsState(
        targetValue = if (scrollState.value > 0) 0.95f else 0f,
        animationSpec = tween(durationMillis = 300), label = ""
    )
    val dividerAlpha by animateFloatAsState(
        targetValue = if (scrollState.value > 0) 1f else 0f,
        animationSpec = tween(durationMillis = 300), label = ""
    )


    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        val guideSectionModifier = Modifier
            .fillMaxWidth()
            .background(KkodlebapTheme.colors.gray100, RoundedCornerShape(10.dp))
            .padding(16.dp)

        Box(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.zIndex(2f)) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = KkodlebapTheme.colors.gray100.copy(alpha = appBarAlpha))
                        .padding(top = 2.dp)
                        .clickable { onClickClose() }
                        .padding(18.dp),
                    text = "닫기",
                    style = Typography.SuitR2,
                    color = KkodlebapTheme.colors.blue600
                )

                HorizontalDivider(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .zIndex(3f),
                    color = KkodlebapTheme.colors.gray200.copy(alpha = dividerAlpha),
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
                    .padding(top = 98.dp)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.img_tutorial_cartoon),
                    contentDescription = "밥풀을 모아 꼬들밥을 지은 여자 아이를 그린 4컷 만화"
                )

                Column(modifier = Modifier.padding(horizontal = 18.dp)) {
                    Text(
                        modifier = Modifier.padding(top = 48.dp),
                        text = "매일 밥풀 하나씩, 꼬들밥 어떠세요? 🍚",
                        style = Typography.SuitB1.copy(fontSize = 20.sp, lineHeight = 26.sp),
                        color = KkodlebapTheme.colors.gray700
                    )

                    Text(
                        modifier = Modifier.padding(top = 36.dp),
                        text = "”꼬들밥\"은 한글 자모를 조합해 단어를 \n" +
                                "맞히는 게임이에요! \n" +
                                "자모 6개로 정답을 유추해 보세요.",
                        style = Typography.SuitR4,
                        color = KkodlebapTheme.colors.gray700
                    )

                    Column(
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .then(guideSectionModifier),
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Text(
                            text = "💙 파란색은 ‘정확한 자모 + 위치까지 정답!’",
                            style = Typography.SuitR4,
                            color = KkodlebapTheme.colors.gray700
                        )
                        Text(
                            text = "🩵 하늘색은 ‘단어에 포함돼 있지만 위치가 달라요!’",
                            style = Typography.SuitR4,
                            color = KkodlebapTheme.colors.gray700
                        )
                        Text(
                            text = "🤍 회색은 ‘정답에 없는 자모예요!’",
                            style = Typography.SuitR4,
                            color = KkodlebapTheme.colors.gray700
                        )
                    }

                    Column(
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .then(guideSectionModifier),
                    ) {
                        Text(
                            text = "예시: 정답이 \"오누이\"일 때 ",
                            style = Typography.SuitSb1,
                            color = KkodlebapTheme.colors.gray700
                        )
                        Text(
                            modifier = Modifier.padding(top = 12.dp),
                            text = "입력 → ㅁ  ㅣ  ㄴ  ㅏ  ㄹ  ㅣ",
                            style = Typography.SuitR4,
                            color = KkodlebapTheme.colors.gray700
                        )
                        Text(
                            modifier = Modifier.padding(top = 6.dp),
                            text = "🩶🩵💙🩶🩶💙",
                            style = Typography.SuitR4,
                            color = KkodlebapTheme.colors.gray700
                        )
                    }

                    Text(
                        modifier = Modifier.padding(top = 24.dp),
                        text = "기회는 총 6번!\n" +
                                "실제 존재하는 단어만 정답으로 등장해요.\n" +
                                "오늘의 꼬들밥을 맛있게 맞혀보세요 😋",
                        style = Typography.SuitR4,
                        color = KkodlebapTheme.colors.gray700
                    )

                    Spacer(modifier = Modifier.height(64.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTutorialModalContent() {
    TutorialModalContent(onClickClose = {})
}
