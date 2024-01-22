# \[Quiz\] 07. Playing Accurately, Part I: Cards Exposed Situations

[main.md](./main.md)

## Q1

以下のような30-60FL Stud Highの5th Streetについて考える。

- ハンドは公開されている。
- X
  - OOP
  - Hand: AhKdQhJsTc
  - Stack: 12000
- Y
  - IP
  - Hand: AsTs8s5s2c
  - Stack: 120
- Pot: 400

### (1)

以下の場合について、XのEVを求めよ。

- X: Bet60/Y: Raise120/X: Call
- X: Bet60/Y: Raise120/X: Fold
- X: Check/Y: Bet60/X: Fold

---

<details>

<summary>Answer (1)</summary>

5th StreetにおけるXのEQを求める。6th, 7th StreetでYにスペードがヒットしなければよく、残りのスペードの枚数は8枚、デッキが52-10=42枚より、

$1 - (\dfrac{8}{42} + \dfrac{42 - 8}{42} \cdot \dfrac{8}{41}) = 0.652$

これより、

`X: Bet60/Y: Raise120/X: Call`  
$0.652 \cdot (400 + 120) + (1 - 0.652) \cdot (-120) \simeq 297$

`X: Bet60/Y: Raise120/X: Fold`  
$-60$

`X: Check/Y: Bet60/X: Fold`  
$0$

</details>

### (2)

以下の場合について、XのEVを求め、YはXのXRについての適切なアクションを求めよ。

- X: Check/Y: Bet60/X: Raise120/Y: Call
- X: Check/Y: Bet60/X: Raise120/Y: Fold

---

`X: Check/Y: Bet60/X: Raise120/Y: Call` について、(1)の`X: Bet60/Y: Raise120/X: Call`と同じ状況のため、 $297$

`X: Check/Y: Bet60/X: Raise120/Y: Fold`について、Xはポットとは別にYがベットした $60$ を獲得するため、 $460$

2人ゲームのため、XのEVが下がればYのEVが上がるため、YはXのXRに対してコールする。

### (3)

以降、Xがチェックした場合Yもチェックし、Xがベットした場合Yはコールするものとする。

5th StreetにてXがチェック、6th StreetにてXがBet60(フラッシュが完成した場合は、XF)したときの、XのEVを求めよ。

---

6thにてフラッシュが完成した場合のEVは、

$\langle X \rangle = 0$

7thにてフラッシュが完成した場合のEVは、

$\langle X \rangle = \dfrac{42 - 8}{42} \cdot \dfrac{8}{41} \cdot (-60) \simeq -9.48$

7thにてフラッシュが完成しなかった場合のEVは、

$\langle X \rangle = (1 - \dfrac{8}{42} - \dfrac{42 - 8}{42} \cdot \dfrac{8}{41}) \cdot (400 + 60) \simeq 299.72$

よって、

$\langle X \rangle \simeq 299.72 - 9.48 \simeq 290$

#### (4)

5th StreetにてXがBet60、6th StreetにてXがBet60したとき(フラッシュが完成した場合は、XF)の、XのEVを求めよ。

---

6thにてフラッシュが完成した場合のEVは、

$\langle X \rangle = \dfrac{8}{42} \cdot (-60) \simeq -11.43$

7thにてフラッシュが完成した場合のEVは、

$\langle X \rangle = \dfrac{42 - 8}{42} \cdot \dfrac{8}{41} \cdot (-120) \simeq -18.95$

7thにてフラッシュが完成しなかった場合のEVは、

$\langle X \rangle = (1 - \dfrac{8}{42} - \dfrac{42 - 8}{42} \cdot \dfrac{8}{41}) \cdot (400 + 60 + 60) \simeq 338.81$

よって、

$\langle X \rangle \simeq 338.81 - 18.95 - 11.43 \simeq 308$

#### (5)

5th StreetにおいてXがチェックした時に、Yはチェックすべきか、ベットすべきか？

---

チェックした場合のXのEVは(3)より、 $290$  
ベットした場合のXのEVは(4)より、 $308$  
Yは、XのEVが小さくなる方を選択すれば良いので、チェックする。

#### (6)

5th StreetにおけるXとYの最適戦略を求めよ。

---

5th Streetにおいて、Xはチェックまたはベットのどちらを選択すべきか？

チェックした場合のXのEVは(4)より $290$ 、ベットした場合のEVは$308$ より、Xはベットを選択する。

Xのベットに対して、Yはフォールド、コール、レイズのどれを選択すべきか？

