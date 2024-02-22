<template>
    <NavBar />
    <div class="my-5">
        <div class="mx-auto w-25" style="max-width: 100;">
            <h2 class="text-center mb-3">Update Patient</h2>
            <form @submit.prevent="updatePatient">
                <!--id-->
                <div class="row">
                    <div class="col-md-12 form-group mb-3">
                        <label for="id" class="form-label">Id</label>
                        <input type="text" name="id" id="id" class="form-control" placeholder="id"
                            v-model="patient.id" />
                    </div>
                </div>
                <!--name-->
                <div class="row">
                    <div class="col-md-12 form-group mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" name="name" id="name" class="form-control" placeholder="Name" required
                            v-model="patient.name" />
                    </div>
                </div>
                <!--email-->
                <div class="row">
                    <div class="col-md-12 form-group mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="text" name="email" id="email" class="form-control" placeholder="Email" required
                            v-model="patient.email" />
                    </div>
                </div>
                <!--phone number-->
                <div class="row">
                    <div class="col-md-12 form-group mb-3">
                        <label for="pno" class="form-label">Phone No</label>
                        <input type="text" name="pno" id="pno" class="form-control" placeholder="Phone Number" required
                            v-model="patient.pno" />
                    </div>
                </div>
                <!--gender-->
                <label for="gender" class="form-label">Gender</label>
                <div class="form-check">
                    <input type="radio" name="Laki-Laki" id="Laki-Laki" value="Laki-Laki" v-model="patient.gender" />
                    <label for="Laki-Laki" class="form-check-label">Laki-Laki</label>
                </div>
                <div class="form-check">
                    <input type="radio" name="perempuan" id="Perempuan" value="Perempuan" v-model="patient.gender" />
                    <label for="Perempuan" class="form-check-label">Perempuan</label>
                </div>
                <!--button-->
                <div class="row">
                    <div class="col-md-12 form-group">
                        <input type="submit" value="Submit" class="btn btn-primary w-100" />
                    </div>
                </div>
            </form>
        </div>
    </div>
</template>

<script>

import NavBar from '@/components/NavBar.vue';

export default {
    name: 'UpdatePatient',
    components: {
        NavBar,
    },
    data() {
        return {
            patient: {
                id: '',
                name: '',
                email: '',
                gender: '',
                pno: '',
            }
        }
    },
    methods: {
        getPatient() {
            fetch(`http://localhost:8082/be-crud-vue/api/patient/get/${this.$route.params.id}`)
                .then(response => response.json())
                .then(data => {
                    console.log(data);
                    this.patient = data;
                })
        },

        updatePatient() {
            fetch('http://localhost:8082/be-crud-vue/api/patient/save', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.patient)
            }).then(data => {
                console.log(data);
                this.$router.push("/");
            })
        }
    },

    beforeMount(){
        this.getPatient()
    }
}

</script>