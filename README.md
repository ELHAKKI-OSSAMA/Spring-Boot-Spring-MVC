# 🏥 Hôpital — Spring Boot MVC + Thymeleaf

![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.3-6DB33F?logo=springboot&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?logo=thymeleaf&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5.3.3-7952B3?logo=bootstrap&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue.svg)

Application web **Spring MVC** affichant une liste de patients avec **recherche**,
**pagination** et **suppression**. Les vues sont rendues avec **Thymeleaf** (mise en page
factorisée via *Thymeleaf Layout Dialect*) et stylées avec **Bootstrap 5** (webjars).

---

## ✨ Fonctionnalités

- 📋 Liste paginée des patients (3 par page).
- 🔎 Recherche par nom (`findByNomContains`).
- 🗑️ Suppression d'un patient (avec confirmation).
- 🎨 Mise en page commune (`template1.html`) appliquée par décoration de layout.

---

## 🧱 Architecture

```
web/        PatientController       → @Controller (MVC), pagination & recherche
repository/ PatientRepository      → JpaRepository + dérivation de requêtes
entities/   Patient                → entité JPA (Lombok @Data/@Builder)
templates/  patients.html          → vue décorée par template1.html (layout)
```

---

## 🚀 Démarrage

### Prérequis
- **JDK 17+**
- **MySQL** (par défaut) — la base `hopital` est créée automatiquement.

### Lancer

```bash
cd hopital
./mvnw spring-boot:run          # Windows : mvnw.cmd spring-boot:run
```

Application disponible sur <http://localhost:8084/index>.

> 💡 **Sans MySQL ?** H2 est inclus. Lancez avec une base en mémoire :
> ```bash
> ./mvnw spring-boot:run -Dspring-boot.run.arguments="--spring.datasource.url=jdbc:h2:mem:hopital --spring.datasource.driver-class-name=org.h2.Driver --spring.datasource.username=sa --spring.jpa.hibernate.ddl-auto=create-drop"
> ```

### Tester

```bash
./mvnw test
```
Les tests tournent sur **H2 en mémoire** et incluent un test **MockMvc** qui rend
réellement la page `/index` (vérifie le rendu Thymeleaf et la décoration de layout).

---

## 🛠️ Corrections & améliorations apportées

- 🐛 `layout:decorate="template1"` → `layout:decorate="~{template1}"` (syntaxe requise par
  Thymeleaf Layout Dialect 3.x — la page ne se décorait pas correctement).
- 🐛 Lignes de données déplacées de `<thead>` vers un `<tbody>` (structure HTML correcte).
- ♻️ Initialisation des données de démo extraite dans un `@Bean CommandLineRunner`
  annoté `@Profile("!test")` (ne pollue plus les tests).
- ✅ Ajout d'une configuration de test H2 + test de rendu MockMvc.
- 🧹 `.gitignore`, MIT `LICENSE`, README, et arrêt du suivi de `target/`.

---

## 👤 Auteur

**EL HAKKI Ossama** — Master SDIA, ENSET.

## 📄 Licence

Distribué sous licence **MIT**. Voir [`LICENSE`](LICENSE).
