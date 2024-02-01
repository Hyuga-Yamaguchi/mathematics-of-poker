# 15. Player X Strikes Back: Full-Street Games

- ゲームを解くときは、解答を途中で止めないことが重要です。今回の拡張されたゲームでも、過去のゲームの結果などを活用しながら、いつもどおりのプロセスで解きました。ある時点で、妥当な解を見つけたように見えました。各選択肢の公平性を比較することで解を確認したところ、まったく新しいアイデアが見つかりました。
- 戦略は、双方が改善できない場合にのみ最適となります！上記の問題を最初に発見したとき(ノーリミットのケースを解こうとしていたとき)、私たちは誤った解を出したと確信しました。結局のところ、より悪いハンドからコールされる可能性もなく、より良いハンドを降ろせる可能性がないハンドでベットすることは愚かなことのように思えます。
- リバーでのベットは、コールされたときの期待値を上げるためのバリューベットか、より良いハンドをフォールドするためのブラフである「はず」です。しかし、このベットはそのどちらでもありません。私たちはこれを先制ベットと呼んでいます。基本的にXがやっていることは、YがQを使ったブラフを思う存分効果的に行えるように、ベットしてそれを先取りしています。Yはレイズブラフで応じることができますが、XがAでより多くの価値を得るため、今度は困難に陥いります。このタイプのプレイは、ベット額が異なる可能性があり、最初のプレイヤーが2番目のプレイヤーのベット額より小さい額をベットできる場合に存在します。
- 先制ベットは負の期待値を持つプレーの完璧な例であるが、そのプレーの期待値はチェックという選択肢よりも小さいでsy。重要なのは、その戦略の価値が代替戦略の価値よりも高いということです。リバーでのノーリミットホールデムには，最適戦略の一部として先制ベットが含まれている可能性が高いです。
- このゲームのもう一つの重要な特徴は，XがKで先制ベットをした後，相手が時々ブラフをしているにもかかわらず，レイズに対して常にフォールドするということです。これは、Xがブラフをかわせる強いハンドをたくさん持っているため、レイズ・ブラフを頻繁にコールする必要がないからです。加えて、レイズブラフは元のベットにKでコールすることに無関心にさせようとするのではなく、レイズブラフはそもそもXにKをベットすることに(チェックすることに)無関心にさせようとするだけです。

これらの概念を念頭に置いて、次は完全なノーリミットのAKQゲームに注目します。このゲームは複雑で難しいので、Chapter15の付録として解答とその正当性を掲載しました。スプレッドリミットの解がどのように導かれたかを理解したならば、ノーリミットゲームの最も重要な教訓を理解したことになります。付録の冒頭には，解を求めるステップを要約し，解を正当化することなく提示するセクションがあります。

---

パートIIIの前編では、ハーフストリートゲームについて説明しました。このゲームでは、プレイヤーXが最初に行動しましたが、必ずチェックをする必要がありました。この後、プレイヤーYはチェックをしてショーダウンを取るか、バリューベットをして適切なブラフをすることができます。CHapter15では、フルストリートゲームの調査を始めます。このゲームでもプレイヤーXが先に行動しますが、今度はベットかチェックのどちらかを選ぶことができます。ベットした場合、プレイヤーYにはレイズかフォールドの選択肢があり、コールすることもできます。チェックした場合、プレイヤーYはチェックすることもベットすることもできます。

ハーフストリートゲーと共通する概念もあれば、そうでない概念もあることを認識することが重要です。例えば、ベットとブラフの比率は、プレイヤーXにとってもYにとっても同じように有効です。しかし、これに加えて、Xがベットするという選択肢を持つことで、**Xがチェックしたときのハンドレンジが変わる**ので、Yのチェックバックは頻繁に変わることになります。これは事実上すべての拡張トイゲームの特徴であり、早い決断のプレイが後の決断のプレイに大きく影響します。

第二の重要な考え方は、**ハーフストリートゲームからフルストリートゲームへ変わっても、残りのゲームが同じであると仮定すれば、プレイヤーXが価値を失うことはない**ということです。もしプレイヤーXの戦略が、ハーフストリートよりもフルストリートの方が期待値が低くなるようなことがあれば、プレイヤーXは、必ずチェックする戦略を採用すればよいのです。これは、戦略的オプションは非負の価値を持つという考え方の自然な延長です。Xが最初からベットすることは、最悪の場合0の価値しかありません。

フルストリートゲーム、そしてハーフストリートゲームよりも複雑なゲームに適用される3つ目の最も重要な考え方は、戦略の概念と表現方法です。ハーフストリートゲーム、特に\[0,1\]Gameでは、各プレイヤーのアクションは一つしかありませんでした。プレイヤーYはベットすることもチェックすることもでき、プレイヤーYがベットすれば、プレイヤーXはコールすることもフォールドすることもできます。プレイヤーXはコールするかフォールドするか、各プレイヤーの戦略は基本的にゲームにおける1つのアクションに過ぎないため、「Fold」という**戦略**と 「Fold」という**戦略オプション**の間には直接的な関係がありました。

ハーフストリートゲームでは、各プレイヤーの戦略は領域で構成されていました。これらの領域は、プレイヤーが特定の戦略オプションを使うハンドレンジであることもありました。これは\[0,1\]Gameのようなゲームで起こりました。他のケースでは、領域は、AKQゲームのようなバラバラの手の混合頻度でした。しかし、どちらの場合でも，プレイヤーはそれぞれの戦略的オプションを取るためのハンドレンジを選択し，それらのレンジの合計が戦略を構成します。

しかし、フルストリートゲームでは、ハーフストリートゲームと状況は少し異なります。プレイヤーXの最初のチェックはゲームのルール上必要でした。しかし今、彼は2つの異なる選択肢をもっています。最初にチェックするかベットするか、そしてそのシナリオに直面した場合にベットに対してコールするかフォールドするかです。私たちの考えでは、これらは実際には2つの異なる決断ではありません。そうではなく、Xが戦略を選択するとき、Xのゲームに対する選択を反映した、より複雑な選択肢の新しいセットを作るのです。最初の決断で2つ、2番目の決断で2つの選択肢がある代わりに、Xは単純にベット、チェックコール、チェックフォールドの3つの決断をします。フルストリートゲームの決定を指定するとき、単にすぐに利用可能なものだけでなく、拡張された戦略的選択肢を反映したペイオフ行列を作成することになります。

このような考えのもと、初のフルストリートゲームを紹介します。

## Ex.15.1 AKQGame\#4

- フルストリートゲーム
- ポットサイズ $P$ (Ex.13.1のAKQゲームと同じ理由で $P>1$ )
- リミットベッティングでサイズは $1$
- レイズは禁止
- このゲームの完全なショーダウンの利得行列は以下の通り

![akq-game-4-table-1](/resources/img/chapter15/akq-game-4-table-1.png)

よりシンプルなゲームを作るために、このゲームから支配的なオプションを即座に取り除くことがでます。プレイヤーXの場合、AのチェックとフォールドはAのチェックとコールに支配され、QのチェックコールはQのチェックフォールドに支配されることがわかります。プレイヤーYの場合、Qでのベットに対するコールか、Aでのベットに対するフォールドが優勢です。さらに、Xのチェックに対してYがAをチェックすることは、Aをベットすることに支配されます。これらを取り除くと次のようなゲームになります。

![akq-game-4-table-2](/resources/img/chapter15/akq-game-4-table-2.png)

この単純なゲームでは、Kをベットすることが両プレイヤーにとって支配的であることがわかります。

![akq-game-4-table-3](/resources/img/chapter15/akq-game-4-table-3.png)

Xは自分のKをすべてチェックし、コールやフォールドして、YがQのブラフに無関心になるようにします。これに加えて、AとQに対する戦略を選択しなければなりません。Aを持っているとき、相手がQを持っているときはブラフを含めてチェックコールするのが得です。しかし、相手がKを持っているときにベットし、相手がチェックコールした場合はベットした方が得です。Qの場合は、相手のKをブラフでフォールドさせることで得をし、相手がAかKを持っていてコールされた場合に損をします。

Yの場合はもう少し単純です。YはKとQの戦略を選ぶだけでよいです。Kでは、XがQでのブラフに無関心になるくらいの頻度でコールします。Ｑでは、XがＫでコールすることに無関心になるくらいの頻度でブラフをかけます。

Xの戦略は次の3つの値で構成されています。

- Aでのベット頻度: $x$
- キングでコールする頻度(XはすべてのKでチェックするので、これはチェックコール頻度である)
- Qでのブラフ頻度: $b$

Yの戦略は次の2つの値で構成されています。

- Kでのコール頻度: $c_y$
- Qでのブラフ頻度: $b_y$

Xがベットする場合を考えます。XはAかQを持っているときだけベットすることがわかっています。YはKを特定の頻度でコールすることで、ブラフに無関心にさせなければなりませんが、これは最初のプレイヤーがAを100%の頻度でベットしてもしなくても同じです。ハーフストリートゲームと同じように，プレイヤーがAとQの二分されたセットをベットした場合，相手はブラフに勝つハンドを正確にフォールドしなければなりません。AKQGame#2([Ex.13.2](/chapter13/main.md#ex132-akq-game-2))と同じロジックを使えば、Xがベットしたとき、Yは $\frac{P - 1}{P + 1}$の頻度でKでコールしなければなりません。これにより、Yはブラフに勝てるハンドの $\alpha$ をフォールドすることになります。

しかしXは、ブラフをかけるQとバリューベットするAの比率を、YがKでコールすることに無関心になるような比率にしなければなりません。ここで行うのは、Yの2つの選択肢のショーダウン後の価値の差を考えることです。YがXのベットをKでコールする場合、Xは2つの異なるハンドを持つことができます。XがAを持っている場合、YがコールするとXは $1$ ベット得をし、Yがフォールドすると $0$ ベット得をします。XがQを持っている場合、Yはコールしたベットだけでなく、ポット全体を獲得します。YはQにコールしてもらうことで $(P + 1)$ ベット獲得し、Aにコールされることで $1$ ベット失います。Xは $P + 1$ の頻度のAに対して、$1$ の頻度のQをベットしなければなりません。

これは次の式で書けます。

$\dfrac{b}{x} = \dfrac{1}{P + 1} = \alpha$ **(15.1)**

ここでも、基本的なブラフ対ベットの関係が成り立つことがわかります。 $b$ は上式で簡単に求めることができるので、残りの分析では $b$ を無視することができます。

次に、Xがチェックする状況を考えてみましょう。ここで、XがすべてのAを持っているのではなく、 $x$ をベットしている可能性があることを除けば、Game#2と同じような状況になります。Yは、これまでと同じ理屈で、自分のA全部とQの $\alpha$ をベットします。Xにはハンドの配分が残っています。Yがブラフに無関心になるためには、Xはブラフに勝つハンドのうち、配分に残っている $\alpha$ をフォールドしなければなりません。

Xが自分のAをすべてチェックしたとすると( $x = 0$ とする)、KとAを同数ずつ持っていることになります。そして、残ったハンドの $\alpha$ をフォールドし、最初にKをフォールドします。AKQGame#2([Ex.13.2](/chapter13/main.md#ex132-akq-game-2))で，Kをフォールドする割合は $\frac{P - 1}{P + 1}$ であることを示しました．しかし、ここでは、Xのハンドの総数はXのAによって減っているので、Xはより多くのKでコールする必要があります。

この時点でXが持っているハンドの総数は、

Total Hands = (All his A) (Fraction of AA he checked) + (All K)  
Total Hands $= \dfrac{1}{2}(1 - x) + \dfrac{1}{2}$

Fraction to fold = $α$(Total Hands)  
$\dfrac{1}{2}(1 - c) = \alpha(\dfrac{1}{2}(1 - x) + \dfrac{1}{2})$  
$c = 1 - 2\alpha + \alpha x$ **(15.2)**

この式は、2つの具体的な $x$ の値を代入して確認することができます。まず $x = 0$ の時の $c$ の値を考えてみましょう。

$c = 1 - 2\alpha + \alpha x$  
$c = 1 - 2\alpha$  
$c = 1 - 2\alpha \dfrac{1}{P + 1}$  
$1 - 2\alpha = \dfrac{P + 1 - 2}{P + 1}$  
$\alpha = \dfrac{P - 1}{P + 1}$

あるいは、 $x = 1$ とします。Xが自分のAをすべてベットした場合、YがQのブラフに無関心になるようにするには、Kを $\alpha$ の頻度でフォールドする必要があります。この式から、 $c = 1 - \alpha$ であることがわかります。

この式で、両者がどのような状況でどのようにプレイするかがわかります。しかし、 $x$ の値はまだわかりません。

ここまでの解をまとめると、

- XはAを $x$ 、Qを $\alpha x$ の頻度でベットします
- Xは残りのQをXFし、残りのAでXCします
- XはKのうち $1 - 2\alpha + \alpha x$ をXCし、残りをXFします
- Xがベットした場合、YはKの $1 - 2\alpha$ とA全部でコールします
- Xがベットした場合、Yは残りのKと全てのQをフォールドします
- Xがチェックした場合、Yは自分のAすべてとQの $\alpha$ をベットし、他のハンドはすべてチェックします

これはゲームを解くときによくあることで、ある特定の変数を除いて最適解が得られることがよくあります。そして、その変数をコントロールする側は、その変数の期待値が最大になるように、その変数を選択するだけです。

$x$ を求めるには、ゲームの期待値を求めなければなりません。6つのケースがあります。

### Case1

- X:A, Y:K

この場合、Xは $x$ の確率でベットし、Yは $1 - 2 \alpha$ の確率でコールし、期待値は $-x(1 - 2\alpha)$ となります。Xがチェックする場合、その値は $0$ です。

### Case2

- X: A, Y: Q

この場合、Xがベットするとゲームの期待値は $0$ になる。Xは $1 - x$ の確率でチェックしてブラフを誘発し、Yは $\alpha$ の確率でブラフします。したがって、期待値は $-\alpha(1 - x)$ となります。

### Case3

- X: K, Y: A

ここでXは常にチェックします。Yがベットすると、Xは $1 - 2\alpha + \alpha x$ の確率でコールします。したがって、このケースの期待値はYに $1 - 2\alpha + \alpha x$ となります。

### Case4

- X:K, Y:Q

ここでXは常にチェックします。Xがコールすると、Yは $1$ ベットを失います。しかし、Xがフォールドすると、Yはポット全額を獲得します。Xの最適戦略はブラフとチェックを無関心にさせ、チェックの価値は $0$ であるため、Yのすべてのブラフによる価値の合計は $0$ でなければならないことがわかります。したがって、ケース4の価値とケース2の価値を足したものは $0$ にならなければなりません。つまり、ケース4の価値は $\alpha(1 - x)$ となります。

### Case5

- X: Q, Y: A

Xは $\alpha x$ の確率でブラフをかけ、Yも $\alpha x$ の頻度でコールします。

### Case6

- X: Q, Y: K

最適戦略ではブラフもチェックも無関心であり、チェックの価値も $0$ です。したがって、ケース6の価値はケース5に-1をかけた者であり、つまり $-\alpha x$ です。

これらの値を表に整理します。

|Hand Matchup|Value to Y|
|:--|:--|
|(A, K)| $-x(1 - 2\alpha)$ |
|(A, Q)| $-\alpha(1 - x)$ |
|(K, A)| $1 - 2 \alpha + \alpha x$ |
|(K, Q)| $\alpha(1 - x)$ |
|(Q, A)| $\alpha x$ |
|(Q, K)| $-\alpha x$ |

次のグラフは、 $P$ と $x$ の値に対するゲームの期待値を示しています。

![equity-of-akq-game-4-for-values-of-x](/resources/img/chapter15/equity-of-akq-game-4-for-values-of-x.png)

このゲームの値は、 $P > 2$ の場合は $x = 1$ で最小になり、 $1 \leq P \leq 2$ の場合は $x = 0$ で最小になります。

そこで、次のような最適戦略があります。

### 最適戦略

#### $P < 2$

- プレイヤーX
  - すべてのハンドをチェックする
  - Aと $\frac{P - 1}{P + 1}$ のKでコール
- プレイヤーY
  - すべてのAと $\frac{1}{P + 1}$ のQをベット

#### $P > 2$

- プレイヤーX
  - すべてのAと $\frac{1}{P + 1}$ のQをベット
  - $\frac{P}{P + 1}$ のKでコール
- プレイヤーY
  - Xがチェックした場合、すべてのAと $\frac{1}{P + 1}$ のQをベット
  - Xがベットした場合、Aと $\frac{P - 1}{P + 1}$ のKでコール

このゲームを説明する際、レイズを選択肢から除外しました。しかし、レイズが許されている場合、どちらのプレイヤーも相手のベットをレイズすることで良くなることはありません(ただし、自分がAを持っていて、相手がクイーンをフォールドする場合を除きます)。したがって，これはレイズが許される場合でも完全なゲームの解です。

この単純なゲームはフルストリートゲームを紹介するものです。基本的に、ハーフストリートゲームとの違いは、プレイヤーが利用できる戦略的オプションの数にあります。ハーフストリートゲームと同じように、ベットとブラフの比率 $\alpha$ とフォールドの比率 $\alpha$ が繰り返されます。さらなる複雑な要素として、ブラフを誘発するかAでベットアウトするかというXの新たな決断から生じました。

次にノーリミットのケースに戻ります。AKQGame#3([Ex.14.1](/chapter14/main.md#ex141-half-street-no-limit-clairvoyance-game))を比較的似た方法で解きました。Yのベットサイズ $s$ の観点から戦略ゲームを解き、 $s$ の選択によってYのエクイティを最大化しました。この章の終わりで、その解説を行います。

しかし、その前に、フルストリートのノーリミットゲームのAKQを解いてみましょう。

## Ex.15.2 AKQGame\#5

- フルストリート
- ポットサイズ $P = 4$
- スプレッドリミットベッティングの特別な形式。どちらの側もチェック(まだアクションがない場合)するか、自分のターンで $1$ か $2$ をベットするかレイズすることができる

AKQ Game#5は、ポット $P = 2$ のAKQGame#4([Ex.15.1](/chapter15/main.md#ex151-akqgame4))と同じですが、ポットの半分の代わりにポットの $\frac14$ をベットするというオプションが追加されています。したがって、このゲームの期待値は、Xがチェックを強制されたハーフストリートゲームの期待値と等しいことがわかります。

[Ex.15.1](/chapter15/main.md#ex151-akqgame4)では、Yのゲームの期待値は次のとおりでした。

$f(1, P) = \dfrac{x(-1 + 3α)+ 1 - 2α}{6}$

ここで、 $x$ は $0$ であり(Xは強制的にチェックするため)、 $\alpha = \dfrac{1}{2 + 1} = \dfrac{1}{3}$ です。

$f(1, 2) = \dfrac{0(-1 + 3α)+ 1 - 2(\dfrac{1}{3})}{6}$  
$f(1, 2) = \dfrac{1 - \dfrac{2}{3}}{6}$  
$f(1, 2) = \dfrac{1}{18}$

しかし、この結果は、ベットサイズ $1$ に対して正規化されたものです。

$f(s=2, P=4) = \dfrac{1}{9}$

これは、両プレイヤーが、許容されるベットサイズが2ユニットだけであるかのようにプレーする戦略に単純に従った場合の、ゲームのエクイティです。ここで、どちらかのプレイヤーが代わりに $1$ をベットすることで利益を得られるかどうかを確認します。XがAで $1$ をベットし、Qで適当にブラフしたとします。するとYはブラフに無関心にさせることで、ハンド全体の $\frac45$ 、つまりすべてのAに加えてKの $\frac35$ でコールすることで対応します。こうすることで、Xは $\frac3{10}$ の確率で $1$ を獲得し、合計で $\frac3{10}$ を獲得することになります。これはチェックした場合のエクイティと対照的です。チェックした場合、Yは自分のQの $\frac13$ ( $\frac12$ の確率で持っている)をブラフし、Aの勝ちが $2$ となり、トータルで $\frac13$ の勝ちになります。 $\frac13$ は $\frac3{10}$ より大きいので、Xは $2$ ではなく $1$ をベットすることで一方的にエクイティを失います。

Xが強制的にチェックをした場合、 $2$ ではなく $1$ をベットしたことによるYのエクイティは以下の通りです。

$f(1,P) = \dfrac{x(-1 + 3\alpha)+ 1 - 2\alpha}{6}$

つまり、$P = 4$の場合、

$f(1, 4) = \dfrac{1 - \dfrac{2}{5}}{6}$  
$f(s=1, P=4) = \dfrac{1}{10}$

よって、YはAで $1$ をベットし、Qで適切にブラフしても得をすることはありません。また、このゲームではYがレイズする可能性があることも分かっています。しかし、XはAとQでベットするだけであり、どちらもYがレイズして利益を得られるハンドではないので、YはAでレイズし(Aでコールする戦略に対して支配的だから)、Qをフォールドします。同じ推論がXにも当てはまります。この種のゲームは、我々がすでに研究してきた原則の簡単な延長に過ぎないように思えます。

本当にそうでしょうか？

これまでの分析に基づくと、次のような戦略があります。

- X
  - すべてのハンドをチェックします(これは他の戦略と共最適です)
  - すべてのAとKの $\frac13$ で2ユニットのベットをコールします。Kの $\frac35$ で1ユニットベットをコールします
- Y
  - Xがベットした場合、AとKの $\frac13$ で $2$ ベットをコールし、AとKの $\frac35$ で $1$ ベットをコールします
  - Xがチェックした場合、すべてのAとQの $\frac13$ で $2$ ベットします

ここで、最適戦略の重要な原則である、**どちらのプレイヤーも戦略を変えることで一方的に期待値を向上させることはできない**ということを思い出しましょう。つまり、異なるハンドをプレイすることで、どちらかのプレイヤーの期待値を向上させることができる場合、その戦略は最適ではないということです。

現在、XはKを持つたびに $\frac23$ のユニットを失っています。相手は半分の確率でQを持っており、 $\frac13$ の確率でブラフをかけます。Xは $\frac13$ の確率でコールするので、 $\frac13$ の確率で $2$ を獲得します。残りの $\frac23$ は $4$ のポットをすべて失い、相手がQを持っているときの損失は合計で $\frac23$ となります。残りの半分はYがAを持っている場合です。この場合、Xは $\frac13$ の確率で $2$ のベットを失います(Xがコールするため)。つまり、YがAを持っている場合の負けは合計で $\frac23$ となります。もちろん、これらの平均は $\frac23$ です。

もしXの戦略を、Kでコールする回数を増やすように、例えば $\frac12$ の確率でコールするように変えると、XはQに対して、Qがブラフをしたときにポットを失わないことで価値を得ますが、Aを払うことでいくらか価値を失うことになります。セカンドプレイヤーのブラフとベットの比率は3対1なので、Kで失う総額は変わりません。

しかし、Kをベットした場合はどうでしょうか？

これまで考えてきたゲームでは、Kをベットすることは、支配的な戦略の最初のセットを取り除いた時点で支配的でした。なぜなら、Kをベットすると、相手のAに対してはベットを失うが、相手のQに対しては何も得られないことが保証されるからです。しかし、今度はKで $1$ をベットすることを考えてみましょう。Yに対するXの戦略は、YがAとKの $\frac35$ でコールすることです。

もしYがそうすれば、XがKで負けるのは、(Aでコールされる)半分の確率で1ユニットを失うことになり、トータルの損失は $\frac12$ となる。この損失は、XがすべてのKをチェックすることによって負っていたユニットの $\frac23$ よりも小さいです。したがって、先に示した戦略が最適であるはずがありません。XはKをチェックする代わりにKで1ユニットベットすることで、一方的にエクイティを向上させることができます。

Yはこのベットにどう対応できるでしょうか？以前はレイズブラフを戦略から除外しました。プレイヤーがKでベットするケースがなかったからです。しかし、今回はそれがあるので、Yはレイズブラフを支配的でない選択肢として考えなければなりません。Xがベットし、YがAを持っている場合、明らかにレイズがフォールドに勝ります。しかし、Aでレイズするだけなら、Xは自分のキングをレイズにフォールドするだけなので、彼は価値を得ることができない。そのため、Yはそれに見合ったブラフの比率でバリューレイズを守らなければなりません。

しかし、ポットが大きくなったので（Xがベットして大きくしたので、2番目のプレイヤーはレイズする前に彼のベットと同じにしなければならない）、おなじみの$s:1 + s$の比率はもはや適用されません。また、セカンドプレイヤーが選択できるブラフ額は2種類あります。2ユニットのレイズ（合計3ユニットを入れる）か、1ユニットのレイズ（合計2ユニットを入れる）です。一見すると、ベットとブラフの比率から、最初のプレイヤーは1ユニットをベットした後にKでコールすることに無関心に違いないと思うかもしれません。その代わり、YはXがKで1ユニット賭けてレイズにフォールドするかチェックするかには無関心になるくらい頻繁にブラフをかけます。

Xはチェックする代わりにKで $1$ ユニット賭けることで、 $\frac{2}{3} - \frac{1}{2} = \frac{1}{6}$ のユニットを得ました。したがって、Yはこの差額を埋め合わせるために十分な頻度でブラフをしなければなりません。2番目のプレイヤーのブラフレイズ頻度を $q$ とします( $1$ ユニット多くレイズした場合)。すると、2番目のプレイヤーはKのブラフに成功するたびに $5$ ユニットを得ます。

(Pot)p(Y has a Q)(Bluffing freq) $= \dfrac{1}{6}$  
$5 \cdot \dfrac{1}{2} \cdot q = \dfrac{1}{6}$  
$q = \dfrac{1}{15}$

レイズ額が2ユニットの場合、YはQで $\dfrac{1}{15}$ の確率でブラフレイズします。この場合、最初のプレイヤーは1ユニットをベットするか、Kをチェックするかで無関心になります。最初のプレイヤーは、2番目のプレイヤーがレイズしたときにKをすべてフォールドすべきです。Yにとって、最初のプレイヤーがKを持っているときに1ユニットレイズしようが2ユニットレイズしようが、Kはどうせフォールドするので問題ではないことに注意してください。しかし、XがAを持っている場合、Yは明らかにQで少額をレイズすることを好むでしょう。

XはKをチェックするにもベットするにも無関心ですが、Aで様々なアクションを取ることに対する期待値は変わりました。XはAをチェックし、Yのブラフをかわすことで、ユニットの $\frac{1}{3}$ を獲得していました。(YはQの $\frac13$ をブラフし、 $2$ ユニット、 $\frac12$ の確率でQを持っています)。今、Xには新しい選択肢があります。Aで1ユニット、Qで適当な比率をベットすることです。これにより、Kでコールしてくる2番目のプレイヤーからいくらかの利益を得ることができます。また、セカンドプレイヤーからレイズブラフを奪うこともできます。

Aで1ユニットをベットした場合の期待値は次のようになります。

$\langle X, bet\ 1 \rangle = p(Y\ calls)(bet) + p(Y\ bluff\ raises)(raise\ amount)$  
$\langle X, bet\ 1 \rangle = \dfrac{3}{5} \cdot \dfrac{1}{2} \cdot 1 + \dfrac{1}{15} \cdot \dfrac{1}{2} \cdot 2$  
$\langle X, bet\ 1 \rangle = \dfrac{11}{30}$

Aをチェックすることによる期待値は、

$\langle X, check \rangle = p(Y\ bluffs)(bet size)$  
$\langle X, check \rangle = \dfrac{1}{2} \cdot \dfrac{1}{3} \cdot 2$  
$\langle X, check \rangle = \dfrac{1}{3}$

つまり、XはAで $1$ ユニット賭けることで、 $\frac1{30}$ のユニットを得たことになります。

これまでのことを振り返ってみましょう。

2つの異なるベットサイズでこのゲームの最適戦略を考察しました。当初は、Kをベットせず、ベットとブラフの比率を含めて最大化するという、これまでのゲームと同じ方法で解くつもりでした。しかし、戦略を見直すと問題が起こりました。以前（ベットサイズが1つしか許されなかったとき）は支配的だったKで小さい額をベットさせることで、Xのエクイティを増やすことができました。

そこで、この方法でYが搾取されないようにするバリューレイズの対応を見つけなければなりませんでした。適切なバリューレイズとそれに対応するブラフを見つけ、XがKでこのようにプレイすることに無関心になるようにしまし。XはAとQで少ない額をベットし、YのKにコールされることでチェックで得たはずのエクイティのほとんどを取り戻し、さらにレイズ・ブラフをコールすることでエクイティを得ることができます。

これらすべての戦略において、Xは自分のAを守るために(Kにコールされるように)Qをベットし、Qを使ったブラフで収支が合うようにします。

XはKをベットしてもチェックしても等しいエクイティを持っていることがわかります(セカンドプレイヤーはこれを確実にするために十分なレイズブラフをしているため)。Aをベットすることで、毎回ユニットの $\frac1{30}$ の利益を得られるので、XはAをすべてベットしたいでしょう。そこで、Yにレイズブラフを続けさせるKとAの比率を見つけなければなりません。Kが多すぎれば、Yはレイズブラフで利益を得る頻度が高くなり、少なすぎれば、Yはレイズブラフで利益を得る頻度が低くなります。

レイズブラフは成功したとき(XがKを持っているとき)に $5$ ユニット得をし、失敗したとき(XがAを持っているとき)に $2$ ユニット損をします。つまり、Yがレイズブラフに無関心になるためには、XはAとKを5:2の割合でベットしなければなりません。このことから、新しい戦略を導けます。

- X
  - すべてのAで1ユニットをベット。Kの $\frac25$ で1ユニットをベット。Qの $\frac15$ で1ユニットをベット。
  - Yが1ユニットレイズしたら、AでリレイズしてKをフォールド
  - Yが2ユニットレイズしたら、AでリレイズしてKをフォールド
  - 残りのKとQでチェック。
  - Kで1ユニットのベットの $\frac45$ 、Kで2ユニットのベットの $\frac23$ をコールする。
- Y
  - Xが2ユニットベットした場合、Aで2ユニットレイズし、Kの $\frac13$ でコールする。Qはフォールド。
  - Xが1ユニットベットした場合、Aで1ユニットレイズし、Qの $\frac1{15}$ でコール。Kの $\frac35$ でコール。
  - Xがチェックした場合、AとQの $\frac13$ で2ユニットベット。Kをチェック

このゲームの総価値は以下の通りです。

![akq-game-5-table-1](/resources/img/chapter15/akq-game-5-table-1.png)

素朴な戦略(Kをベットしない戦略)の期待値は $\frac16$ です。この戦略の価値は　$-\frac1{10}$　で、その差は $\frac1{90}$ です。

もしXが相手の戦略が決まっていることを知っていたら、XはAで1ユニットではなく2ユニットを賭けることを好むでしょう。しかし、Kの場合は、より少額をベットすることを好みます。Aで大きくベットするよりも、先手を打つ方が(この場合)価値があるためです。