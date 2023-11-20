# \[Quiz\] 04. Playing the Odds: Pot Odds and Implied Odds

[main.md](chapter04/main.md)

## Quiz

### Q1. ポットオッズ

以下のようなFixed Limit Holdemを考える。

- No raise
- Pot: 400
- 30-60
- プレイヤー
  - A(OOP)
    - Hand: AcAd
  - B(IP)
    - Hand: 9h8h
- Turn
  - Kh7c3s2h
  - つまり、リバーでBのフラッシュが完成するアウツの枚数は9枚である。
- お互いのハンドは互いに公開されているものとする

#### (1)

プレイヤーAがチェックした場合、プレイヤーBは必ずチェックバックすることを示せ。

プレイヤーBがベットに対してAがコールした場合の、AのEV $\langle A, call \rangle$ と、フォールドした場合のAのEV $\langle A, fold \rangle$ は、

|A|Value|Prob|
|:--|:--|:--|
|リバーでフラッシュが完成しない|$(400 + 60 + 60) - 60=460$|$\frac{35}{44}$|
|リバーでフラッシュが完成する|$0-60=-60$|$\frac{9}{44}$|

$\langle A, call \rangle = 460 \cdot \frac{35}{44} + (-60) \cdot \frac{9}{44} = 353.64$

$\langle A, fold \rangle = 0$

これより、Bがベットした場合、Aは必ずコールし、その時のAのEVは $353.64$ である。

プレイヤーBがチェックバックした場合の、AのEV $\langle A \rangle$ は、

|A|Value|Prob|
|:--|:--|:--|
|リバーでフラッシュが完成しない|$400 - 0=400$|$\frac{35}{44}$|
|リバーでフラッシュが完成する|$0-0=0$|$\frac{9}{44}$|

$\langle A \rangle = 400 \cdot \frac{35}{44} - 0 = 318.18$

以上より、Bがチェックした時の方がAのEVが低く、Bはチェックバックすべきである。

#### (2)

プレイヤーAがチェックした場合のEV $\langle A, check \rangle$ を求めよ。

|A|Value|Prob|
|:--|:--|:--|
|リバーでフラッシュが完成しない|$400 - 0=400$|$\frac{35}{44}$|
|リバーでフラッシュが完成する|$0-0=0$|$\frac{9}{44}$|

$\langle A, check \rangle = 400 \cdot \frac{35}{44} - 0 = 318.18$

#### (3)

プレイヤーAがベットした場合、プレイヤーBはコールとフォールドのどちらを選択するか？  
また、AのEV $\langle A, bet \rangle$ を求めよ。

Bがコールした場合のEVを $\langle B, call \rangle$ 、フォールドした場合のEVを $\langle B, fold \rangle$ とおくと、

|B|Value|Prob|
|:--|:--|:--|
|リバーでフラッシュが完成しない|$0 - 60=-60$|$\frac{35}{44}$|
|リバーでフラッシュが完成する|$(400 + 60 + 60)-60=460$|$\frac{9}{44}$|

$\langle B, call \rangle = (-60) \cdot \frac{35}{44} + 460 \cdot \frac{9}{44} = 46.36$

$\langle B, fold \rangle = 0$

$\langle B, call \rangle > \langle B, fold \rangle$ より、Bはコールする。

Bがコールした場合の、AのEV $\langle A, bet \rangle$ は、

|A|Value|Prob|
|:--|:--|:--|
|リバーでフラッシュが完成しない|$(400 + 60 + 60) - 60=460$|$\frac{35}{44}$|
|リバーでフラッシュが完成する|$0-60=-60$|$\frac{9}{44}$|

$\langle A, call \rangle = 460 \cdot \frac{35}{44} + (-60) \cdot \frac{9}{44} = 353.64$

#### (4)

Turnにて、Aはチェックまたはベットのどちらを選択すべきか？

(3)までより、ベットした方がAの期待値は高いのでベットすべきである。基本的に、ドローvsメイクハンドでは、メイクハンドがベットするのが普通である。

