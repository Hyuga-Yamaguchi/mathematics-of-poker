# [Note] 03. Using All the Information: Estimating Parameters and Bayes' Theorem

## 頻度論的信頼区間(Confidence Interval)とベイズ確信区間(Baysian Credible Interval)の違いについて

基本的にchapter03のまとめである。

### 頻度論的信頼区間

$n$ 個のデータから計算されたパラメータ $\theta$ (よく平均値が使われる)の信頼区間は、そのパラメータが属する母集団の標準偏差 $\sigma$ と信頼レベル $z$ を用いて以下のように表される。

$(\theta - z\dfrac{\sigma}{\sqrt{n}}, \theta + z\dfrac{\sigma}{\sqrt{n}})$

ここで、 $z$ はよく、標準正規分布の95%のデータが含まれる範囲にある $z = 1.96$ を用いる。

しかし、基本的に母集団の標準偏差はわからないので、**代わりに標本標準偏差 $s$ を使い、パラメータ分布は $t$ 分布に従うと仮定する**。

$(\theta - t\dfrac{s}{\sqrt{n}}, \theta + t\dfrac{s}{\sqrt{n}})$

cf. [t分布を超わかりやすく解説(t分布で区間推定！)【統計学入門26】](https://datawokagaku.com/t_dist/)

#### 信頼区間のよくある誤解

以下は全て頻度論的信頼区間に対するよくある誤解である。

- 95%信頼区間であれば、ランダムに抽出された標本の95%はその信頼区間の範囲である
- 95%信頼区間であれば、何度もランダムに標本を抽出したとき、95%の確率で興味のあるパラメータ(例えば平均値)がその信頼区間の範囲内である
- 95%信頼区間であれば、ランダムに抽出された標本から得られた興味のあるパラメータ(例えば平均値)のばらつく範囲のうち、95%の範囲を示している

正確な意味は以下である。

- **95%信頼区間とは、実験を100回繰り返した時、それぞれの実験で得られた興味のあるパラメータ(例えば平均値)が、その信頼区間に収まっている実験の頻度が、95回である**

頻度論者の哲学を知ると理解しやすい。

興味のあるパラメータには真の値が存在する  
-> そのパラメータの真の値は、母集団から導かれる(しかし標本は母集団の一部である)  
-> それぞれの実験で得られた興味のあるパラメータは、ある信頼区間に収まることも、収まらないこともある  
-> **パラメータの値は本来一つである(確率変数ではない)が、複数回による実験で生まれるばらつきを定量化したい**

### ベイズ確信区間

頻度論的信頼区間は直感的ではない。よって、「興味のあるパラメータがこの範囲に含まれる確率は95%である」というような主張をしたい。

ベイジアンは(パラメータは真の値を持つとは考えず) **パラメータ $\theta$ 確率変数であり、確率分布 $P(\theta)$ に従うと考える**。

#### ベイズの定理

データ $y$ を与えるモデルパラメータ $\theta$ を決めると、ベイズの定理が成り立つ。

$P(\theta | y) = \dfrac{P(y | \theta)P(\theta)}{\sum_yP(y | \theta)P(\theta)}$

$P(\theta)$: **事前確率分布** データを観測する以前における $\theta$ の値に対する確率分布

$P(y | \theta)$: **尤度関数** モデルパラメータ $\theta$ が決まった時の、データ $y$ の確率分布

$P(\theta | y)$: **事後確率分布** データ $y$ を観測した後における、モデルパラメータ $\theta$ の確率分布

これにより、例えば95%の $\theta$ が含まれる範囲をその事後確率分布 $P(\theta | y)$ を直接計算できる。

##### イメージ

###### 離散型のベイズの定理

全事象を $\Omega$ とし、全事象をいくつかの既知情報 $A_1, A_2, ..., A_n$ に分割する(例では $n = 5$ とする)。ここで、 $A_1, A_2, ..., A_n$ は互いに交わらず、全て合わせると全事象 $\Omega$ となる。

これらの事象が成り立つ確率 $P(A_1), ..., P(A_n)$ を**事前確率**と呼ぶ。

![bayes-split](/resources/img/chapter03/note/bayes-split.png)

続いて新規情報 $B$ が発生したとする。 $B$ は必ず $A_1, A_2, ..., A_n$ と交わるとする。

![bayse-theorem](/resources/img/chapter03/note/bayes-theorem.png)

このとき、「新規情報 $B$ が発生した条件のもとで、それまで既知情報だった $A_i$ が発生する確率 $P(A_i | B)$ 」を求めたい。これを求めるのがベイズの定理であり、$P(A_i | B)$ は事後確率と呼ばれる。

まず、条件付き確率の定義式は以下の通りである。

$P(A_i | B) = \dfrac{P(A_i \cap B)}{P(B)}$

$P(B | A_i) = \dfrac{P(A_i \cap B)}{P(A_i)}$

これより、

$P(A_i \cap B) = P(A_i | B)P(B) = P(B | A_i)P(A_i)$

であるため、

$P(A_i | B) = \dfrac{P(B | A_i)P(A_i)}{P(B)}$ ...(1)

である。

次に、 $A$ のとりうる値が複数あるとすると、 $A$ が互いに独立であるという条件のもと(上の図の通り)では、

$P(B) = \sum\limits_{i = 1}^nP(A_i \cap B) = \sum\limits_{i = 1}^nP(B | A_i)P(A_i)$ ...(2)

式(1)、 (2)より、

$P(A_i | B) = \dfrac{P(B | A_i)P(A_i)}{\sum\limits_{i = 1}^nP(B | A_i)P(A_i)}$

となる。

###### 連続型のベイズの定理

既知情報 $A_1, A_2, ..., A_n$ は $\theta$ となり、パラメータを指す。

新規情報 $B$ は $x$ となり、データを指す。

つまり、連続型のベイズの定理は、「新しいデータ $x$ が与えられた状況で、それまで既知だった $\theta$ が取りうる値の分布」を求めている。

$\pi(\theta | x) = \dfrac{f(x | \theta)\pi(\theta)}{\int_{\theta}f(x | \theta)\pi(\theta)d\theta}$

$\pi(\theta)$: 事前確率分布  
$\pi(\theta | x)$: 事後確率分布  
$f(x | \theta)$: 尤度関数  
$\int_{\theta}f(x | \theta)\pi(\theta)d\theta$: 周辺尤度

###### 具体例

https://ai-trend.jp/basic-study/bayes/bayes-theorem/

### 例1: ジャンケン

「Aさんは100回ジャンケン(あいこなし)をして42回しか勝てなかった。Aさんはじゃんけんが弱いと言えるか？」

#### 頻度論的解答

Aさんの勝率 $\theta$ はサンプルでは $0.42$ であるが、これは母集団の一部によるものでしかなく、真の値が存在するため、信頼区間を計算すればよい。

今回の母集団は、勝つ確率 $\theta$ 、負ける確率 $1 - \theta$ の2通りの結果であるので、二項分布に従う。100回のジャンケンによる勝ち数の分布の平均は、中心極限定理より、平均 $100\theta$ 、分散 $100\theta(1 - \theta)$ の正規分布に従うとする。(cf. [二項分布の正規近似（ラプラスの定理）](https://manabitimes.jp/math/1107))

>##### (補足)ド・モアブル-ラブラスの定理
>
>二項分布 $Bin(n, p)$ は $n$ が十分に大きい時、平均 $np$ 、分散 $np(1 - p)$ の正規分布に近づく

分散は既知であるため、 $x = 1.96$ を用いて、95%信頼区間は以下のように計算できる。

$(100 \theta - 1.96 \sqrt{100\theta(1 - \theta)}, 100 + 1.96 \sqrt{100\theta(1 - \theta)})$

これに $\theta = 0.42$ を代入すると、 $(32.3, 51.7)$ である。これの意味するところは、100回ジャンケンをして勝率を求める実験をたくさん繰り返すと、そのうち95%は $32.3 \leq (win rate) \leq 51.7$ になる。じゃんけんの実力が全く同じ場合の平均値 $50$ が含まれているため、Aさんはじゃんけんが弱いとは言えない。

#### ベイジアン的解答

じゃんけんは、複数の独立した試行のもと、勝つまたは負けるの2通りのため、データ $y$ が与える確率分布は二項分布になる。

勝率 $\theta$ 、試行回数を $N$ 、勝ち数を $y$ とした場合、尤度関数は以下のように書ける。

$P(y | \theta) = \binom{N}{y}\theta^y(1 - \theta)^{N - y}$

事前確率分布 $P(\theta)$ はベータ分布とする。

>##### (補足)ベータ分布
>
>ベータ分布とは、確率密度関数が $f(x) = Cx^{a - 1}(1 - x)^{b - 1}$ $(0 \leq x \leq 1)$ であるような確率分布である。
>
>ただし、$a, b$ はパラメータ(正の実数)であり、 $C$ は正規化定数である。
>
>cf. [ベータ分布の意味と平均・分散の導出](https://manabitimes.jp/math/1267)

$P(\theta) = B(\alpha, \beta)$ とし、ベータ分布の平均は $\frac{\alpha}{\alpha + \beta}$ 、サンプルサイズは $\alpha + \beta$ である。ここで、じゃんけんは勝つか負けるかの2通りであり、 $P(\theta)$ の平均は $0.5$ が適切であるため、 $\alpha = \beta = 50$ とする。つまり、

$P(\theta) = B(50, 50)$

である。

TODO
